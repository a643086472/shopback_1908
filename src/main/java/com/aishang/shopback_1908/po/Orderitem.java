package com.aishang.shopback_1908.po;

import javax.persistence.*;

@Table(name = "shop..orderitem")
public class Orderitem {
    @Id
    private Integer itemid;

    private Integer count;

    private Double subtotal;

    private Integer pid;

    private Integer oid;

    /**
     * @return itemid
     */
    public Integer getItemid() {
        return itemid;
    }

    /**
     * @param itemid
     */
    public void setItemid(Integer itemid) {
        this.itemid = itemid;
    }

    /**
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * @return subtotal
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

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
     * @return oid
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * @param oid
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }
}