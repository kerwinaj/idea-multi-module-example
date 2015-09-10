package ddl;

import dal.annotation.Column;
import dal.annotation.Id;
import dal.annotation.Table;
import dal.common.DbType;

@Table(name = "goods_list")
public class Goods extends BaseDdl {

    @Id()
    @Column(name = "goods_id", type = DbType.BigInt)
    public Long goodsId;

    @Column(name = "seller_id", type = DbType.BigInt)
    public Long sellerId;

    @Column(name = "category_id", type = DbType.BigInt)
    public Long categoryId;

    @Column(name = "title", type = DbType.Varchar)
    public String title;

    @Column(name = "price", type = DbType.Double)
    public Double price;

    @Column(name = "unit_price", type = DbType.Double)
    public Double unitPrice;

    @Column(name = "account_id", type = DbType.Varchar)
    public String accountId;

    @Column(name = "deal_type", type = DbType.SmallInt)
    public Integer dealType;

    @Column(name = "goods_status", type = DbType.SmallInt)
    public Integer goodsStatus;

    @Column(name = "audit_status", type = DbType.SmallInt)
    public Integer auditStatus;

    @Column(name = "game_id", type = DbType.Int)
    public Integer gameId;

    @Column(name = "publisher_id", type = DbType.Int)
    public Integer publisherId;

    @Column(name = "domain_id", type = DbType.Int)
    public Integer domainId;

    @Column(name = "server_id", type = DbType.Int)
    public Integer serverId;

    @Column(name = "if_claim", type = DbType.SmallInt)
    public Integer ifClaim;

    @Column(name = "storage", type = DbType.Int)
    public Integer storage;

    @Column(name = "image_flag", type = DbType.SmallInt)
    public Integer imageFlag;

    @Column(name = "ctime", type = DbType.Int)
    public Integer createTime;

    @Column(name = "utime", type = DbType.Int)
    public Integer updateTime;

    @Column(name = "reason", type = DbType.Varchar)
    public String reason;

    @Column(name = "category_name", type = DbType.Varchar)
    public String categoryName;

    @Column(name = "server_name", type = DbType.Varchar)
    public String serverName;

    @Column(name = "domain_name", type = DbType.Varchar)
    public String domainName;

    @Column(name = "publisher_name", type = DbType.Varchar)
    public String publisherName;

    @Column(name = "real_title", type = DbType.Varchar)
    public String realTitle;

    @Column(name = "game_name", type = DbType.Varchar)
    public String gameName;

    @Column(name = "p_id", type = DbType.Int)
    public Integer pId;

    @Column(name = "discount", type = DbType.Double)
    public Double discount;

    @Column(name = "orig_price", type = DbType.Double)
    public Double origPrice;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public Integer getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Integer getIfClaim() {
        return ifClaim;
    }

    public void setIfClaim(Integer ifClaim) {
        this.ifClaim = ifClaim;
    }

    public Integer getImageFlag() {
        return imageFlag;
    }

    public void setImageFlag(Integer imageFlag) {
        this.imageFlag = imageFlag;
    }

    public Double getOrigPrice() {
        return origPrice;
    }

    public void setOrigPrice(Double origPrice) {
        this.origPrice = origPrice;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getRealTitle() {
        return realTitle;
    }

    public void setRealTitle(String realTitle) {
        this.realTitle = realTitle;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public Integer getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }
}