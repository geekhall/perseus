package cn.geekhall.hera.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author yiny
 * @since 2022-03-26
 */
@Getter
@Setter
@TableName("h_product")
@ApiModel(value = "Product对象", description = "")
public class Product extends Model<Product> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品描述")
    private String description;

    @ApiModelProperty("品牌")
    private String brand;

    @ApiModelProperty("价格")
    private BigDecimal price;

    private Boolean isDeleted;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
