package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.Bank;
import kr.hs.sdh.toast.entity.BankCustomer;
import kr.hs.sdh.toast.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BankCusomerRepository {
    @Select("""
    SELECT bc.* FROM bank_customer bc inner join bank_customer_bridge bcb 
    on bc.bc_uuid = bcb.uuid 
    where bcb.b_uuid = #{b_uuid}
""")
    List<BankCustomer> findAll(String uuid);

    @Select("SELECT * FROM bank_customer where bc_identity = #{identity}")
    BankCustomer findIden(String identity);
}
