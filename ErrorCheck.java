


class ErrorCheck extends ErrorWrite{
    public void Name(String s) throws Exception{
        if(s.length() > 2 && s.matches("[A-Z][a-z]*")){
            System.out.println("Name is correct");
        }
        else throw new Exception("Incorrect name");
    }
    public void IIN(String s) throws Exception{
        if(s.length() == 12){
            System.out.println("IIN is valid");
        }
        else throw new Exception("Invalid IIN!");
    }
    public void Phone(String s) throws Exception{
        if(s.length() == 11){
            System.out.println("Phone is valid");
        }
        else throw new Exception("Invalid phone");
    }
}