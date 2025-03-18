package cleancode.studycafe.tobe.io;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputHandlerTest {

    private InputHandler inputHandler;

    @Test
    @DisplayName("1번을 선택하면 시간권이 선택된다.")
    void chooseHourly() {
        // given
        String input = "1\n";
        setInput(input);
        inputHandler = new InputHandler();

        // when
        StudyCafePassType result = inputHandler.getPassTypeSelectingUserAction();

        // then
        assertThat(result).isEqualTo(StudyCafePassType.HOURLY);
    }

    @Test
    @DisplayName("2번을 선택하면 주간권이 선택된다.")
    void chooseWeekly() {
        // given
        String input = "2\n";
        setInput(input);
        inputHandler = new InputHandler();

        // when
        StudyCafePassType result = inputHandler.getPassTypeSelectingUserAction();

        // then
        assertThat(result).isEqualTo(StudyCafePassType.WEEKLY);
    }

    @Test
    @DisplayName("3번을 선택하면 고정권이 선택된다.")
    void chooseFixed() {
        // given
        String input = "3\n";
        setInput(input);
        inputHandler = new InputHandler();

        // when
        StudyCafePassType result = inputHandler.getPassTypeSelectingUserAction();

        // then
        assertThat(result).isEqualTo(StudyCafePassType.FIXED);
    }

    @Test
    @DisplayName("1,2,3이 아닌 다른 것을 선택하면 예외가 발생한다,")
    void chooseAnyThing() {
        // given
        String input = "10\n";
        setInput(input);
        inputHandler = new InputHandler();

        // when

        // then
        assertThatThrownBy(() -> inputHandler.getPassTypeSelectingUserAction()).hasMessage("잘못된 입력입니다.");
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
