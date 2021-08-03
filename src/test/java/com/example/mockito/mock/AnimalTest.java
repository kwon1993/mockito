package com.example.mockito.mock;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AnimalTest {

    @Test
    public void mockTest() {
        Animal animal = mock(Animal.class);
        assertNotNull(animal);

        when(animal.getAge()).thenReturn(30);
        when(animal.getName()).thenReturn("참새");
        when(animal.getIsFly()).thenReturn(true);

        assertEquals(30, animal.getAge());
        assertEquals("참새", animal.getName());
        assertEquals(true, animal.getIsFly());
    }

    @Test
    public void mockTest2() {
        Animal animal = mock(Animal.class);
        doThrow(new RuntimeException()).when(animal).setAge(eq(20));
        Throwable throwable = Assertions.catchThrowable(() -> {
            animal.setAge(20);
        });
        Assertions.assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void mockTest3() {
        Animal animal = mock(Animal.class);
        animal.setName("참새");

        // n번 호출했는지 체크
        verify(animal, times(1)).setName(any(String.class)); // success
        // 호출 안했는지 체크
        verify(animal, never()).getName(); // success
        verify(animal, never()).setName(eq("호랑이")); // success
        // 최소한 1번 이상 호출했는지 체크
        verify(animal, atLeastOnce()).setName(any(String.class)); // success
        // 2번 이하 호출 했는지 체크
        verify(animal, atMost(2)).setName(any(String.class)); // success
        // 지정된 시간(millis)안으로 메소드를 호출 했는지 체크
        verify(animal, timeout(100)).setName(any(String.class)); // success
        // 지정된 시간(millis)안으로 1번 이상 메소드를 호출 했는지 체크
        verify(animal, timeout(100).atLeast(1)).setName(any(String.class)); // success
    }


}