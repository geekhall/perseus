package cn.geekhall.hera.server.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
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
@TableName("h_weapon")
@ApiModel(value = "Weapon对象", description = "")
public class Weapon extends Model<Weapon> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键ID")
    private Long id;

    @ApiModelProperty("武器名称")
    private String name;

    @ApiModelProperty("武器描述")
    private String description;


    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
