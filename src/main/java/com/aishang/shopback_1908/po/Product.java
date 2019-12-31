package com.aishang.shopback_1908.po;

import java.util.Date;
import javax.persistence.*;

@Table(name = "shop..product")
public class Product {
    @Id
    private Integer pid;

    private String pname;

    @Column(name = "market_price")
    private Double marketPrice;

    @Column(name = "shop_price")
    private Double shopPrice;

    private String image;

    private String pdesc;

    @Column(name = "is_hot")
    private Integer isHot;

    private Date pdate;

    private Integer csid;

    /**
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * @return pname
     */
    public String getPname() {
        return pname;
    }

    /**
     * @param pname
     */
    public void setPname(String pname) {
        this.pname = pname;
    }

    /**
     * @return market_price
     */
    public Double getMarketPrice() {
        return marketPrice;
    }

    /**
     * @param marketPrice
     */
    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    /**
     * @return shop_price
     */
    public Double getShopPrice() {
        return shopPrice;
    }

    /**
     * @param shopPrice
     */
    public void setShopPrice(Double shopPrice) {
        this.shopPrice = shopPrice;
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return pdesc
     */
    public String getPdesc() {
        return pdesc;
    }

    /**
     * @param pdesc
     */
    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    /**
     * @return is_hot
     */
    public Integer getIsHot() {
        return isHot;
    }

    /**
     * @param isHot
     */
    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    /**
     * @return pdate
     */
    public Date getPdate() {
        return pdate;
    }

    /**
     * @param pdate
     */
    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    /**
     * @return csid
     */
    public Integer getCsid() {
        return csid;
    }

    /**
     * @param csid
     */
    public void setCsid(Integer csid) {
        this.csid = csid;
    }
}