package org.axis.helpy.callapi.repository;

import org.axis.helpy.callapi.entity.CallDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallDetailRepository extends JpaRepository<CallDetail,Long> {
}
