class Solution {
    public String simplifyPath(String path) {
        if(path.length() == 1) return path;
String[] p = path.split("/");
String res = "";
int count = 0;

    for (int i = p.length - 1 ; i >=0; i--){
        String temp = p[i];
        if(!temp.equals("") && !temp.equals(".")){
            if(temp.equals("..")){
                count++;
            }else if(count == 0){
                res = "/" + temp + res;
            }else{
                count --;
            }
        }
    }
    if(res.length() == 0 && path.length() != 0){
        return "/";
    }
     return res;
    }
}