package com.sparksys.file.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * description: 文件素材实体类
 *
 * @author zhouxinlei
 * @date 2020-05-24 12:38:24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("file_material")
@ApiModel(value = "文件素材对象", description = "文件素材表")
public class FileMaterial implements Serializable {

    private static final long serialVersionUID = -6231176716837859634L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private Long id;

    @TableField("uid")
    @ApiModelProperty(value = "文件唯一标识")
    private String uid;

    @TableField("file_name")
    @ApiModelProperty(value = "文件名称")
    private String fileName;

    @TableField("suffix")
    @ApiModelProperty(value = "文件后缀名")
    private String suffix;

    @TableField("file_path")
    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @TableField("size")
    @ApiModelProperty(value = "文件大小")
    private Double size;

    @TableField("content_type")
    @ApiModelProperty(value = "媒体类型")
    private String contentType;

    @TableField("create_time")
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


}
