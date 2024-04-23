package org.sekator.jdbi3.dto;

import jakarta.persistence.Table;
import lombok.Data;
import org.jdbi.v3.core.mapper.reflect.ColumnName;
import org.springframework.context.annotation.Primary;

/**
 * @author dn070578noi
 * @created 23 кві, 2024
 */
@Data
@Table(name = "reward_group")
public class RewardGroup {
    @ColumnName("id")
    private Long id;
    @ColumnName("name")
    private String name;
    @ColumnName("description")
    private String description;

    public RewardGroup(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
