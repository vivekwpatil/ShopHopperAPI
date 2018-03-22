package be.ing.api.provider;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

/**
 * Created by D-YD95PD on 22/03/2018.
 */

@Entity
@Table(name = "shop")
public class ShopEntity {

    @Id
    @Column(name = "shop_id")
    private int shopId;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_address")
    private String shopAddress;

    @Column(name = "shop_phone_number")
    private String shopPhoneNumber;

    @OneToMany(/*fetch = FetchType.LAZY,  cascade=CascadeType.ALL,*/mappedBy = "shop")
    @JsonManagedReference
    private List<ReceiptEntity> receipts;

    public List<ReceiptEntity> getReceiptEntity() {
        return receipts;
    }

    public void setReceiptEntity(List<ReceiptEntity> receipts) {
        this.receipts = receipts;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopPhoneNumber() {
        return shopPhoneNumber;
    }

    public void setShopPhoneNumber(String shopPhoneNumber) {
        this.shopPhoneNumber = shopPhoneNumber;
    }
}
