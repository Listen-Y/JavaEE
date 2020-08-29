package listen.model;

import java.util.Date;
import listen.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 学生表
 */
@Getter
@Setter
@ToString
public class Record extends BaseEntity {
    
    private Integer id;

    private Integer memberId;

    private Integer awardId;

    /**
     * 创建时间
     */
    private Date createTime;
}