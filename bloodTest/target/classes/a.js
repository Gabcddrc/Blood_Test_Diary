var romanToInt = function(s) {
  var x =0;
  var s = s.split("")
  for(let i = 0; i<s.length; i++){
      let tmp = s[i];
      if(tmp == "I"){
          x++;
      } 
      else if(tmp = "V"){
          if(i>0 && s[i-1] == "I"){
              x+=3
              console.log(x)
          }
          else {x+=5}
      }
      else if(tmp = "X"){
          if(i>0 && s[i-1] == "I"){
              x+=8
          }
          else {x+=10}
      }
      else if(tmp = "L"){
          if(i>0 && s[i-1] == "X"){
              x+=30
          }
          else {x+=50}
      }
      else if(tmp = "C"){
          if(i>0 && s[i-1] == "X"){
              x+=80
          }
          else {x+=100}
      }
      else if(tmp = "D"){
          if(i>0 && s[i-1] == "C"){
              x+=300
          }
          else {x+=500}
      }
      else if(tmp = "M"){
          if(i>0 && s[i-1] == "C"){
              x+=800
          }
          else {x+=1000}
      }
  }
  return x;
};
console.log(romanToInt("IX"))