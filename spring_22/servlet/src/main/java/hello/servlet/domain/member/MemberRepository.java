package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); // 동시성이 고려되지 않으므로 실무에선 cuncurrent, atomic을 고려해야 함
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); // 싱글톤으로 사용

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){

    }

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById (Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    // 테스트용
    public void clearStore(){
        store.clear();
    }
}
