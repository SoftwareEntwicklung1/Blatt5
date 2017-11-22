

public class Intersection {
    /*
    requires a != null
    modifies \nothing
    ensures \result == (es existiert ein int i in [0,a.length-1], so dass a[i] == x)
    */
    public static boolean contains(int[] a, int x) {
         for (int i=0;i<a.length;i++){
             if(a[i]==x){
                 return true;
             }
         }
        return false;
    }

    /*
    requires a != null
    modifies \nothing
    ensures \result == (fuer alle int i in [0,a.length-2]: a[i] < a[i+1])
    */
    public static boolean increasing(int[] a) {
        if(a.length==1 || a.length==0){
            return true;
        }
        if(a.length==2 && a[0]>a[1] ){
            return false;  
        }
        for(int i=0;i<a.length-1;i++){
            if(i==a.length-2){
                return true;
            }
             if(a[i]>a[i+1]){
               break;
            }
        }
        return false;
    }

    /*
    requires a != null
          && b != null
          && increasing(a)
          && increasing(b)
    modifies \nothing
    ensures \result == (fuer alle int x: !contains(a, x) || contains(b,x))
    */
    public static boolean subset(int[] a, int[] b) {
        if(a.length==0&&b.length==0||a.length==0){
            return true;
        }
        if(increasing(a)&&increasing(b)){
        
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
               if(a[i]==b[j]){
                break;
               }
               if(j==b.length-1){
                   return false;
               }
            }
           if(i==a.length-1) {
               return true;
            }
        }
        return false;
       }else{
          return false;
       }
      }

    /*
    requires a != null
          && b != null
          && increasing(a)
          && increasing(b)
    modifies \nothing
    ensures \result != null
         && (fuer alle int x: (contains(a, x) && contains(b, x)) == contains(\result, x))
         && increasing(\result)
    */
    public static int[] intersection(int[] a, int[] b) {
        if(a.length==0||b.length==0){
            return new int[]{};
        }
        if(!increasing(a)){
            System.out.println("Find a non-increasing ");
        }
        if(!increasing(b)){
            System.out.println("Find a non-increasing ");
        }
        int m=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i]==b[j]){
                    m++;

                }
            }

        }
        int[] c=new int[m];
        int n=0;
           for(int i=0;i<a.length;i++){
               a:for(int j=0;j<b.length;j++){
                  if(a[i]==b[j]){ 
                    c[n]=a[i];
                    n++;
                    break a;
                    }
               }

            }
        
        return c;
    }
}
