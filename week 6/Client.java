class Client{
    private String name;
    private String phone;
    private String id;
    
    Client(String name, String phone, String id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }
}

