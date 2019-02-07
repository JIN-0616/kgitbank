<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>[test_jQuery1.jsp]</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#tabs" ).tabs({
      event: "mouseover"
    });
  } );
  </script>
</head>
<body>
 
<div id="tabs">
  <ul>
    <li><a href="#tabs-1">KG 한국</a></li>
    <li><a href="#tabs-2">KB</a></li>
    <li><a href="#tabs-3">NH</a></li>
  </ul>
  <div id="tabs-1">
    <p>~~~~~~~~~~~~~~~봉쥬르~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
  </div>
  <div id="tabs-2">
    <p>================================================================</p>
  </div>
  <div id="tabs-3">
    <p>%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%</p>
    <p>****************************************************************</p>
  </div>
</div>
 
 
</body>
</html>