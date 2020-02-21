Hasanian Alsabonchi

1)Write a JavaScript function min1() that takes an array of numbers as argument and returns 
the smallest number in the array. 
You must implement this function using a loop statement.

function Min1(arr)
{
 
 var min= arr[0] 
            for(var i=1;i<arr.length;i++){
              
                  if(arr[i]< min){
                   
                   min=arr[i] 
                  }    
            }   
    return min
  
}
var arr=[11,23,33,4,53]
var result=Min1(arr)
console.log(result)
---------------------------------------------

2)

#forEach

function Min2(arr){
var sml=arr[0]
arr.forEach(function(element,index) {
        if(arr[index] <sml){
          sml=element
        }
      
});
return sml   
}
var arr=[11,23,33,4,53]
var result=Min2(arr)

 console.log(result)

--------------------------------------------------------------------
3)Write a JavaScript function factorial() that takes an positive integer n and returns n!, 
which is 1*2*..*(n-1)*n. 
You must implement this function using recursion


 function factorial(x) 
{ 

  if (x === 0)
 {
    return 1;
 }
  return x * factorial(x-1);
         
}
console.log(factorial(5));


4)
Write a JavaScript function palindrome() that takes a string and determine if it's a plindrome, i.e. a word that reads the same forward and backward, 
e.g. "racecar". You must implement this function using String methods.

function palindrome(str) {

    var len = str.length;
    var mid = Math.floor(len/2);

    for ( var i = 0; i < mid; i++ ) {
        if (str.charAt(i) !== str.charAt(len - 1 - i)) {
            return false;
        }
    }

    return true;
}
palindrome("raceca")