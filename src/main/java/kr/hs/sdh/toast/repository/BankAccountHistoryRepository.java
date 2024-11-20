package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.BankAccountHistory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

@Mapper
public interface BankAccountHistoryRepository {
    String BANK_ACCOUNT_HISTORY = "kr.hs.sdh.toast.repository.BankAccountHistoryRepository.bankAccountHistory";
    @ConstructorArgs({
            @Arg(column = "bah_amount", name = "amount"),
            @Arg(column = "bah_bef_amount", name = "beforeAmount"),
            @Arg(column = "bah_memo", name = "memo"),
            @Arg(column = "bah_type", name = "type"),
            @Arg(column = "bah_trans_date", name = "transDateTime")
    })
    @Results(id = "bankAccountHistory")
    @Select(value = "")
    BankAccountHistory bankAccountHistory();

    @ResultMap(value = "bankAccountHistory")
    @Select("select * from bank_account_history where ba_number = #{accountNumber} order by bah_trans_date desc")
    List<BankAccountHistory> findAllByAccountNumber(final String accountNumber);

}
