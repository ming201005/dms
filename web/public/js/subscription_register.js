//<!-- 注册  --start-->

var accountsure = false;
var passwordsure = false;
var verifysure = false;

function successMsg(){
	$(".notice_msg").text('');
}
function errorMsg(msg){
	msg = msg;
	$(".notice_msg").removeClass("hidden").text(msg);
}

//账户验证
$("input[name='account']").on("change",function(){
	accountsure=false;
	//账户变更后 清空原来的手机验证码输入
	$("input[name='verify']").val("");
	let _this = this;
	if(!$(_this).val()){
	    errorMsg('账户不能为空')
	    accountsure = false;
	    return false;
	}
	let phoneReg = /^1[\d]{10}$/;
	if(!phoneReg.test($(_this).val())){
	    errorMsg('账户必须是手机号')
	    accountsure = false;
	    return;
	}
	successMsg();
});

//密码验证
$(".check_psd").on("change",function(){
	passwordsure = false;
	let psdinfo = psdcheck(this);
	if(psdinfo.status=='0'){
		errorMsg(psdinfo.msg)
	}else{
		passwordsure = true;
		successMsg();
	}
	
});

//验证码获取
$(".getcode,.regetcode").click(function(){
   if(!$(this).hasClass("disabled")){
	   verifysure = false;
	   accountcheck($("input[name='account']")[0],getCode);
   }
	   
});
//验证码验证
$("input[name='verify']").on("change",function(){
	var _this = this;
	verifysure = false;
  var verify = $(_this).val();
  if(!verify){
  	errorMsg('验证码不能为空');
      return;
  }
  if(codeget==1 && codevalidity==0){
  	errorMsg('验证码过期，请重新获取验证码');
  }
  if(codeget==0){
  	errorMsg('请先获取验证码');
  }
  if(codeget==1 && codevalidity==1 && verify!=''){
      var url = './api.php';
      var data = {
          "url" : "/Api/PaasUser/getVerify/account/"+$('input[name="account"]').val()+"/verify/"+verify,
          "method": "get",
          "type":"checkverify"
      };
      $.post(url,data,function(res){
          if(res.code != 200){
               errorMsg(res.msg);
          }else{
          	verifysure= true;
          	 successMsg();
          }
      },'json');
  }
});


function accountcheck(obj,callback=''){
	  accountsure=false;
	  //账户变更后 清空原来的手机验证码输入
	  $("input[name='verify']").val("");
	  let _this = obj;
	  if(!$(_this).val()){
	      errorMsg('账户不能为空')
	      accountsure = false;
	      return false;
	  }
	  let phoneReg = /^1[\d]{10}$/;
	  if(!phoneReg.test($(_this).val())){
	      errorMsg('账户必须是手机号')
	      accountsure = false;
	      return;
	  }
	  let account = $(_this).val();
	  data={
	      "url" : "/Api/PaasUser/checkaccountUC/account/"+account,
		  "method": "get",
		  "type":"checkaccount",
	  };
	  if(account){
	      $.ajax({
	          type:'post',
		      url : './api.php',
		      data:data,
		      async:false,
		      dataType:'json',
		      success:function(res){
		    	  if(res.code!=200){
		              accountsure = false;
		              if(res.msg == '用户名重复,请更换。'){
		            	  res.msg= '该账户已注册，可直接切换[立即登录]'
	                  }
	                  errorMsg(res.msg);
	              }else{
	              	  successMsg();
	                  accountsure = true;
	                  console.log(typeof callback === "function");
	                  typeof callback === "function" ? callback($(".getcode")[0],account) : false;
	              }
	          }
	      });
	  }
}
function psdcheck(obj){
	//数字字母混合
	let value = $(obj).val();
	let data = {'status':'0','msg':''}
	if(value==''){
		data.msg = "密码不能为空";
		return data;
	}else{
		let patten = /^[a-zA-Z0-9]+$/;
		let ret = patten.test(value);
		if(false === ret){
			data.msg = "密码不能为空";
			return data;
		}
		let patten1 = /[a-zA-Z]+/;
		let ret1 = patten1.test(value);
		if(false === ret1){
			data.msg = "密码必须是字母数字混合,缺少字母";
			return data;
		}
		let patten2 = /[0-9]+/;
		let ret2 = patten2.test(value);
		if(false === ret2){
			data.msg = "密码必须是字母数字混合,缺少数字";
			return data;
		}
		data.status = '1';
		return data;
  }
}
//注册提交
$(".user_register").on("click",function(){
	var _this = this;
	if(accountsure!==true){
		$("input[name='account']").change();
      return false;
  }
	
  if(verifysure!==true){
      $("input[name='verify']").change();
      return false;
  }
  if(passwordsure!==true){
  	$(".check_psd").change();
  	return false;
  }
  var params = $('#login input').serialize();
  var url = './api.php';
  var account = $("input[name='account']").val();
  $(_this).attr("disabled",true).addClass('animation').find('label').html('正在注册');
  $.ajax({
      type:"post",
      url:url,
      data:{
          "url" : "/Api/PaasUser/registerUC",
          "type":"register",
          "method": "post",
          "params":params,
      },
      dataType:'json',
      success:function(res){
          if(res.code==200){
              var uchref = res.list.uchref;
              if( uchref && uchref != '' ){
              	$("input[name='account']").append(uchref);
              }
              localStorage.account = res.list.account;
              localStorage.projectid=res.list.projectid;
              if(res.list.authcookie){
             	  setCookie("Website_auth",res.list.authcookie);
              }
              setTimeout(()=>{
                  //登录成功跳转首頁
                  window.location.href = "https://mp.weixin.qq.com/s/O43oeW3YndfaeQoZbYEGfA";
              },200);
          }else{
              alert(res.msg);
              $("input[name='password']").val('');
              $(".user_register").removeClass("tml-register-check");
              $(_this).attr("disabled",false).removeClass('animation').find('label').html('立即注册');
          }
      },
      error:function(){
          $(".user_register").removeClass("tml-register-check");
          $(_this).attr("disabled",false).removeClass('animation').find('label').html('立即注册');
      },
  });
});
var maxtime = 60;
var time = 60;   //验证码有效时间
var codetime=-1;    //验证码有效剩余时间
var codeget = 0;    //是否获取过验证码
var codevalidity = 0;   //验证码是否过期
function getCode(obj,phone){
	var url = './api.php';
   $(".getcode").addClass("hide");
   $(".regetcode").removeClass("hide");
   $.ajax({
       type:"post",
       url:url,
       data:{
           "url" : "/Api/PaasUser/getVerify/account/"+phone,
           "type":"getcode",
           "method": "get"
       },
       success:function(res){
           if(typeof(res)=='string'){
               res = $.parseJSON(res);
           }
           if(res.code==200){
          	 codeget = 1;
          	 codevalidity = 1
               codetime = time;
               var ref = setInterval(function(){
            	   codetime--;
                   codetext = codetime+'s后重新获取';
                   if(codetime>=0){
                       $(".regetcode ").text(codetext)
                   }else{
                       clearInterval(ref);
                       $(".regetcode ").text('');
                       $(".regetcode").addClass("hide");
                       $(".getcode").removeClass("hide");
                       codetime = time;
                       codevalidity = 0;
                       //$(".regetcode").css("color","#999");
                   }
               },1000);
           }else{
               $(".regetcode").addClass("hide");
               $(".getcode").removeClass("hide");
          	 if(res.code==1009){
          		 errorMsg("获取验证码超时");
          	 }else{
          		 errorMsg(res.msg);
          	 }
           }
           return;
       },
       error:function(){
           $(".regetcode").addClass("hide");
           $(".getcode").removeClass("hide");
       },
   });

}
function setCookie(c_name,value,expiredays)
{
	var exdate=new Date()
	exdate.setDate(exdate.getDate()+expiredays)
	document.cookie=c_name+ "=" +escape(value)+
	((expiredays==null) ? "" : ";expires="+exdate.toGMTString())
}
//<!-- 注册  --end-->