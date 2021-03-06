package sdgkteam10.rent_it;


import android.util.Log;

import java.io.Serializable;
import java.util.HashMap;

class Item implements Serializable{
    private String itemName;
    private String price;
    private String priceRate;

    private String description;
    private String[] imageArray;
    private String category;

    private String itemUserID;
    private String minRentDur;
    private String minDurationSpinner;

    private String depositAmount;
    private String depositReqd;

    //private String depositNotReqd;
    private String priceNeg;
    private String item_Buyout;
    private int uniqueID;


    private String zipcode;
    private String contactInfo;


    private boolean favored;


    public boolean getFavored(){return favored;}
    public void setFavored(boolean b){
        favored = true;
    }

    public Item() {
        favored = false;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public String getPriceRate() {
        return priceRate;
    }

    public void setPriceRate(String priceRate) {
        this.priceRate = priceRate;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String[] getImageArray() {
        return imageArray;
    }

    public void setImageArray(String[] imageArray) {
        this.imageArray = imageArray;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getItemUserID() {
        return itemUserID;
    }

    public void setItemUserID(String itemUserID) {
        this.itemUserID = itemUserID;
    }

    public String getMinRentDur() {
        return minRentDur;
    }

    public void setMinRentDur(String minRentDur) {
        this.minRentDur = minRentDur;
    }

    public String getMinDurationSpinner() {
        return minDurationSpinner;
    }

    public void setMinDurationSpinner(String minDurationSpinner) {
        this.minDurationSpinner = minDurationSpinner;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    // this is for the "Yes!" check box
    public String getDepositReqd() {
        return depositReqd;
    }

    public void setDepositReqd(String depositReqd) {
        this.depositReqd = depositReqd;
    }

    /* this is for the "No." check box
    public String getDepositNotReqd() {
        return depositNotReqd;
    }
    public void setDepositNotReqd(String depositNotReqd) {
        this.depositNotReqd = depositNotReqd;
    }*/

    public String getPriceNeg() {
        return priceNeg;
    }

    public void setPriceNeg(String priceNeg) {
        this.priceNeg = priceNeg;
    }

    public String getItemBuyout() {
        return item_Buyout;
    }

    public void setItemBuyout(String item_Buyout) {
        this.item_Buyout = item_Buyout;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getZipcode() {
        return this.zipcode;
    }
    public void setZipcode(String zipcode ) {
        this.zipcode = zipcode;
    }

    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo ) {
        this.contactInfo = contactInfo;
    }

    //used in checking favorites list
    //TODO: make this more robust
    @Override
    public boolean equals(Object e) {
        if (e != null && e instanceof Item) {
            Item other = (Item) e;

            if (this.getItemName().equals(other.getItemName()) &&
                    this.getDescription().equals(other.getDescription())) {
                return true;
            } else {
                return false;
            }
        }
        //TODO -- Minor Bug: initially items stored as HashMap (but still works)
        else if (e != null && e instanceof HashMap) {
            HashMap other = (HashMap) e;

            if (this.getItemName().equals(other.get("itemName").toString()) &&
                    this.getDescription().equals(other.get("description").toString())) {
                return true;
            }
            return false;
        }
        else
            return false;

    }

    //TODO: make this more robust
    @Override
    public int hashCode() {
        return this.getItemName().hashCode() + this.getDescription().hashCode();
    }
}
/*

public String get() {
        return ;
    }
public void set(String ) {
        this. = ;
    }


* */