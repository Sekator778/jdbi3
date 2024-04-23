package org.sekator.jdbi3.cotroller;

import lombok.RequiredArgsConstructor;
import org.sekator.jdbi3.dto.RewardGroup;
import org.sekator.jdbi3.service.RewardGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author dn070578noi
 * @created 23 кві, 2024
 */
@RestController
@RequestMapping("/api/reward-group")
@RequiredArgsConstructor
public class RewardGroupController {
    private final RewardGroupService rewardGroupService;

    @RequestMapping("/all")
    public List<RewardGroup> getAll() {
        return rewardGroupService.getAll();
    }
}
