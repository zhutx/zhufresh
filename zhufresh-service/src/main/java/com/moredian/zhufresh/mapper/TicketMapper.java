package com.moredian.zhufresh.mapper;

import com.moredian.zhufresh.domain.Ticket;
import com.moredian.zhufresh.domain.TicketQueryCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface TicketMapper {

    int insert(Ticket ticket);

    int updateDispatchOperIdByIds(@Param("dispatchOperId") Long dispatchOperId, @Param("dispatchOperName") String dispatchOperName, @Param("ticketIdList") List<Long> ticketIds, @Param("oldStatus") Integer oldStatus, @Param("newStatus") Integer newStatus);

    List<Ticket> findByDispatchOperId(@Param("dispatchOperId") Long dispatchOperId, @Param("status") Integer status);

    Ticket loadByCode(@Param("ticketCode") String ticketCode);

    int updateBindUserId(@Param("ticketId") Long ticketId, @Param("bindUserId") Long userId, @Param("status") Integer status);

    Ticket load(@Param("ticketId") Long ticketId);

    List<Ticket> findTicketByUserId(@Param("bindUserId") Long userId, @Param("status") Integer status);

    int updateStatus(@Param("ticketId") Long ticketId, @Param("status") Integer status);

    int updateStatusForExpire(@Param("oldStatus") Integer oldStatus, @Param("newStatus") Integer newStatus, @Param("expireDate") Date expireDate);

    int getTotalCountByCondition(TicketQueryCondition condition);

    List<Ticket> findPaginationByCondition(TicketQueryCondition condition);

}
