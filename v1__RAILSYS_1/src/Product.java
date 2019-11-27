public class Product{

    private String id;
    private String name;
    private int qte;
    private int price;
    private byte[] Image;
    
    public Product(){}
    
    public Product(String Id, String Name, int Qte, int Price,byte[] image){
    
        this.id = Id;
        this.name = Name;
        this.qte = Qte;
        this.price = Price;
        this.Image = image;
        
       
    }
    
    
    public String getID(){
      return id;
    }
    
    public void setID(String ID){
        this.id = ID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String Name){
        this.name = Name;
    }
    
    public int getQte(){
        return qte;
    }
    
    public void setQte(int Qte){
        this.qte = Qte;
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int Price){
        this.price = Price;
    }
    
  
    
    public byte[] getMyImage(){
        return Image;
    }
}
