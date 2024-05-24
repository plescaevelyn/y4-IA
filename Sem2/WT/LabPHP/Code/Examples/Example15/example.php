<?
class  Max{
       var $var1;
       var $var2;
       function  iniţializare($var11, $var22) {
           $this->var1=$var11;//variabila var1 primeste valoarea variabilei //var2
               //transmisă ca argumet
           $this->var2=$var22;}
       function verificare ($var11, $var22)  {
           if ($this->var1>$this->var2)
           {
               return false;
           } //dacă var1 este mai mare ca var2
               //atunci rezultatul întors de funcţie //este  false
           else { return true;}
       }
       }

$ex1 = new Max;
$ex1->verificare(12,13)
?>
