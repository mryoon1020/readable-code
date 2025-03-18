package cleancode.studycafe.tobe.model.order;


import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    private StudyCafeSeatPass seatPass;
    private StudyCafeLockerPass lockerPass;
    private StudyCafePassOrder studyCafePassOrder;


    @BeforeEach
    void init() {
        seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 12, 700000, 0.15);
        lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 12, 30000);

    }

    @Test
    @DisplayName("고정석 12주권의 가격은 625000원이다. ")
    void getTotalPrice() {
        // given
        studyCafePassOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = studyCafePassOrder.getTotalPrice();
        // then
        assertThat(totalPrice).isEqualTo(625000);
    }


    @Test
    @DisplayName("고정석 12주권의 할인된 가격은  105000원이다. ")
    void getDuration() {
        // given
        studyCafePassOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = studyCafePassOrder.getDiscountPrice();
        // then
        assertThat(totalPrice).isEqualTo(105000);
    }

}
