package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.BankAccount;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.cache.Cache;

import java.util.List;


@Mapper
public interface BankAccountRepository {

    @ConstructorArgs({
            @Arg(column = "ba_number", name = "number", id = true),
            @Arg(column = "ba_amount", name = "amount"),
            @Arg(column = "ba_alias", name = "alias"),
            @Arg(column = "ba_create_date", name = "createDateTime"),
            @Arg(column = "ba_maturity_date", name = "maturityDateTime"),
            @Arg(column = "ba_freeze", name = "isFreeze")
    })
    @Results(id = "bankAccount")
    @Select(value = "")
    BankAccount bankAccountConstructor();

    @Results(
            id = "bankAccountResults",
            value = {
                    @Result(column = "ba_number", property = "number", id = true),
                    @Result(column = "ba_amount", property = "amount"),
                    @Result(column = "ba_alias", property = "alias"),
                    @Result(column = "ba_create_date", property = "createDateTime"),
                    @Result(column = "ba_maturity_date", property = "maturityDateTime"),
                    @Result(column = "ba_freeze", property = "isFreeze"),
                    @Result(column = "bb_uuid", property = "bankBook", one = @One(resultMap = BankBookRepository.BANK_BOOK)),
                    @Result(column = "ba_number", property = "bankAccountHistories", many = @Many(resultMap = BankAccountHistoryRepository.BANK_ACCOUNT_HISTORY ))
            })
    @Select(value = "")
    BankAccount bankAccountResults();

    @ResultMap("bankAccountResults")
    @Select("""
        SELECT ba.*, bb.*, bah.* FROM BANK_ACCOUNT AS ba
        INNER JOIN PEOPLE AS p ON ba.p_uuid = p.p_uuid
        INNER JOIN bank_book as bb on ba.bb_uuid = bb.bb_uuid
        left outer join bank_account_history bah on ba.ba_number =  bah.ba_number
        WHERE p.p_identity = #{identity}
    """)
    List<BankAccount> findAllByIdentity(String identity);
}