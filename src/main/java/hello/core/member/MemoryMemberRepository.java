package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
//    ConcurrentHashMap 을 사용하면 좋다. 그냥 HashMap은 동시성 이슈가 있을 수 있기 때문에 동시성 문제를 해결할 수 있는 ConcurrentHashMap 을 사용할 수 있다.(참고)

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
