package step2.util;

import static org.assertj.core.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.platform.commons.util.ReflectionUtils;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName(value = "유효성 검증기 테스트")
class ValidatorTest {

	@Test
	void 인스턴스화_하려는_경우_예외() throws NoSuchMethodException {
		Constructor<Validator> validatorConstructor = Validator.class.getDeclaredConstructor();
		validatorConstructor.setAccessible(true);

		assertThatExceptionOfType(AssertionError.class)
			.isThrownBy(() -> ReflectionUtils.newInstance(Validator.class));
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@NullSource
	void null_체크(String input) {
		assertThatIllegalArgumentException().isThrownBy(
			() -> Validator.notNull(input, ErrorTarget.DIRECTION)
		);
	}

	@ParameterizedTest(name = "{displayName} : {arguments}")
	@NullAndEmptySource
	void Blank_체크(String input) {
		assertThatIllegalArgumentException().isThrownBy(
			() -> Validator.notBlank(input, ErrorTarget.NAME_INPUT)
		);
	}

	@Test
	void 최솟값_체크() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> Validator.min(10, 9, "")
		);
	}

	@Test
	void 최댓값_체크() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> Validator.max(10, 11, "")
		);
	}

	@Test
	void 컬렉션에서_중복_값_체크() {
		assertThatIllegalArgumentException().isThrownBy(
			() -> Validator.duplicate(List.of("1", "1"), "")
		);
	}

}