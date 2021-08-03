package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        // 잘못된 로그 사용법
        // + 연산을 사용하면 로그 레벨을 debug로 설정해놓아서 trace 레벨은 출력되지 않지만
        // 내부에서는 + 연산이 작동해 CPU연산이 일어나고 메모리도 할당된다.
        // 하지만 우리는 debug 레벨까지만 요청했으므로 trace 레벨이 작동될 필요가 없으니 그만큼의 낭비가 되는것이다.
        log.trace("trace mylog" + name);

        // 올바른 로그 사용법
        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }


}
