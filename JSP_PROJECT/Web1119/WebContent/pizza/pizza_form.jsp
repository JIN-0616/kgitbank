<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>[pizza_form.jsp]</title>
<style type="text/css">
	*{ font-size:14pt; font-weight:bold; }
	
	.relative{
	  /* 왼쪽 div 밖의레이아웃 */
	  position: relative;
	  width: 429px;
	  height: 180px; 
	  background-image: url('pizza_images/bgpizza.jpg');
	  background-position: top left ; 
	}
	
	.absolute{
	  /* 오른쪽 div 안쪽레이아웃 */
	  position: absolute;
	  top: 0;
	  right: 0;
	  width: 213px;
	  height: 180px; 
	  background-image: url('pizza_images/bgpizza.jpg');
	  background-position: top right ; 
	}
	
</style>

<script type="text/javascript">
	function changePizzaL(name) {
	  var filename = "url('pizza_images/" + name + ".jpg')";
	  preview_l.style.backgroundImage = filename;
	  preview_l.style.backgroundPosition = "top left";
	}
	
	function changePizzaR(name) {
	  var filename = "url('pizza_images/" + name + ".jpg')";
	  preview_r.style.backgroundImage = filename;
	  preview_r.style.backgroundPosition = "top right";
	}
</script>
</head>
<body>
<form  method="post">
  <div id="preview_l" class="relative">
    <div id="preview_r" class="absolute"> </div>
  </div>

  <p>
  <select name="pizzaListLeft" onchange="changePizzaL(this.value)">
	<option value="bgpizza" selected="selected">피자를 선택하세요</option>
	<option value="dw_d">도이치휠레 더블치즈엣지</option>
	<option value="dw">도이치휠레</option>
	<option value="rb_d">리얼바비큐 더블치즈엣지</option>
	<option value="rb">리얼바비큐</option>
	<option value="qcc_d">베이컨체더치즈 더블치즈엣지</option>
	<option value="bcc">베이컨체더치즈</option>
	<option value="bgg_d">불고기 더블치즈엣지</option>
	<option value="bgg">불고기</option>
	<option value="bp">브레이즈드 포크</option>
	<option value="sd_d">슈퍼디럭스 더블치즈엣지</option>
	<option value="sd">슈퍼디럭스</option>
	<option value="ss_d">슈퍼슈프림 더블치즈엣지</option>
	<option value="ss">슈퍼슈프림</option>
	<option value="wnb">와규 앤 비스테카</option>
	<option value="fs">직화 스테이크</option>
	<option value="cp">치즈피자</option>
	<option value="cp_d">치즈피자 더블치즈엣지</option>
	<option value="ks">킹프론 씨푸드</option>
	<option value="ppr_d">페퍼로니 더블치즈엣지</option>
	<option value="ppr">페퍼로니</option>
	<option value="pt_d">포테이토 더블치즈엣지</option>
	<option value="pt">포테이토</option>
  </select>

  <select name="pizzaListRight" onchange="changePizzaR(this.value)">
	<option value="bgpizza" selected="selected">피자를 선택하세요</option>
	<option value="dw_d">도이치휠레 더블치즈엣지</option>
	<option value="dw">도이치휠레</option>
	<option value="rb_d">리얼바비큐 더블치즈엣지</option>
	<option value="rb">리얼바비큐</option>
	<option value="qcc_d">베이컨체더치즈 더블치즈엣지</option>
	<option value="bcc">베이컨체더치즈</option>
	<option value="bgg_d">불고기 더블치즈엣지</option>
	<option value="bgg">불고기</option>
	<option value="bp">브레이즈드 포크</option>
	<option value="sd_d">슈퍼디럭스 더블치즈엣지</option>
	<option value="sd">슈퍼디럭스</option>
	<option value="ss_d">슈퍼슈프림 더블치즈엣지</option>
	<option value="ss">슈퍼슈프림</option>
	<option value="wnb">와규 앤 비스테카</option>
	<option value="fs">직화 스테이크</option>
	<option value="cp">치즈피자</option>
	<option value="cp_d">치즈피자 더블치즈엣지</option>
	<option value="ks">킹프론 씨푸드</option>
	<option value="ppr_d">페퍼로니 더블치즈엣지</option>
	<option value="ppr">페퍼로니</option>
	<option value="pt_d">포테이토 더블치즈엣지</option>
	<option value="pt">포테이토</option>
  </select>

	<p><label>고객명　　<input></label></p>
	<p><label>전화번호　<input type="tel"></label></p>
	<p><label>E-mail　　<input type="email"></label></p>
	<fieldset>
	<legend>피자 사이즈</legend>
	<p><label><input type="radio" name="size">Small</label></p>
	<p><label><input type="radio" name="size">Medium</label></p>
	<p><label><input type="radio" name="size">Large</label></p>
	</fieldset>
	<fieldset>
	<legend>토핑 선택</legend>
	<p><label><input type="checkbox">베이컨</label></p>
	<p><label><input type="checkbox">치즈</label></p>
	<p><label><input type="checkbox">양파</label></p>
	<p><label><input type="checkbox">버섯</label></p>
	</fieldset>
	<p><label>희망배송시간　　<input type="time" min="10:00" max="22:00" step="900"></label></p>
	<p><label>배송시요청사항　<textarea name="comments" maxlength="1000" rows="2" cols="30" style="vertical-align:middle; resize:none;"></textarea></label></p>
	<p><button>피자주문하기</button></p>
</form>
</body>
</html>
