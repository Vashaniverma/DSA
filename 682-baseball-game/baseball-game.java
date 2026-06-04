class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("C")){
                s.pop();
            }
            else if(operations[i].equals("D")){
                int a=s.peek();
                s.push(a*2);
            }
            else if(operations[i].equals("+")){
                int a= s.pop();
                int b= s.peek();
                s.push(a);
                s.push(a+b);
            }else{
                int a=Integer.parseInt(operations[i]);
                s.push(a);
            }

        }
        int sum=0;
        while(!s.isEmpty()){
            sum+=s.pop();
        }
        return sum;
        
    }
}