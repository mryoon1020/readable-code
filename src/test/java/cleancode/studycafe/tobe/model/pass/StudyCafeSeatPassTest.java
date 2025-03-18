package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeSeatPassTest {
    private StudyCafeSeatPass seatPass;

    @BeforeEach
    void init() {
        seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
    }

    @Test
    @DisplayName("입력한 패스권이 고정권이다.")
    void isSamePassType() {

        boolean result = seatPass.isSamePassType(StudyCafePassType.FIXED);
        assertThat(result).isTrue();

    }

    @Test
    @DisplayName("입력한 패스권이 고정권이다.")
    void isNotSamePassType() {

        boolean result = seatPass.isSamePassType(StudyCafePassType.HOURLY);
        assertThat(result).isFalse();

    }

}
