## TDD란 무엇인가
기능을 검증하는 테스트 코드를 먼저 작성하고 테스트를 통과시키기 위해 개발을 진행하는 방법이다.

<br>

## TDD Cycle (Red - Green - Refactor의 반복)

> 테스트를 먼저 작성하고 테스트를 통과시킬 만큼 코드를 작성하고 리팩토링으로 마무리하는 과정을 반복한다.  

1. 기능을 검증하는 테스트를 먼저 작성한다.
2. 작성한 테스트를 통과하지 못하면 테스트를 통과할 만큼만 코드를 작성한다.
3. 테스트를 통과한 뒤에 개선할 코드가 있다면 리팩토링한다.
4. 다시 테스트를 실행해서 기존 기능이 그대로 동작하는지 확인한다.
5. 1-4를 반복하여 기능을 완성한다.

<br>

## 장점
- 개발 과정에서 지속적으로 코드 정리를 하기 때문에 코드 품질이 급격히 나빠지지 않게 막을 수 있으므로 유지보수 비용을 낮춘다.
- 새로운 코드를 추가하거나 기존 코드를 수정할 때 테스트를 이용해서 제대로 동작하는지 바로 확인할 수 있으므로 잘못된 코드가 배포되는 것을 방지한다.
