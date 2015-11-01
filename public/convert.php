<html>
<body>
<h1>Convert acre-feet to cubic meters!!!</h1>
<?if (isset($_REQUEST["acreFeet"])) {?>
   <p><?=$_REQUEST["acreFeet"]?> acre-feet in cubic meters is:<p>
   <p class="result"><?=$_REQUEST["acreFeet"]*1233.48?></p>
<?}?>
<form action="convert.php">
   Acre-feet: <input type="text" name="acreFeet" /><input type="submit" value="convert!"/>
</form>
</body>
</html>