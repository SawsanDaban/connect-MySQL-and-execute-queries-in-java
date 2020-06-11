package carsdata;

public class car {
    int       modelNo =   0;
    String  modelName =  "";
    double modelPrice = 0.0;
    int modelQuantity =   0;

    public car() {
        
    }
    
    public car(int modelNo, String modelName, double modelPrice, int modelQuantity) {
        this.modelNo = modelNo;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
        this.modelQuantity = modelQuantity;
    }
    

    public int getModelNo() {
        return modelNo;
    }

    public void setModelNo(int modelNo) {
        this.modelNo = modelNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getModelPrice() {
        return modelPrice;
    }

    public void setModelPrice(double modelPrice) {
        this.modelPrice = modelPrice;
    }

    public int getModelQuantity() {
        return modelQuantity;
    }

    public void setModelQuantity(int modelQuantity) {
        this.modelQuantity = modelQuantity;
    }
}
