package com.jnape.palatable.lambda.functions.builtin.fn3;

import com.jnape.palatable.lambda.functions.Fn1;
import com.jnape.palatable.traitor.annotations.TestTraits;
import com.jnape.palatable.traitor.runners.Traits;
import org.junit.Test;
import org.junit.runner.RunWith;
import testsupport.traits.EmptyIterableSupport;

import static com.jnape.palatable.lambda.functions.builtin.fn3.FoldRight.foldRight;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static testsupport.functions.ExplainFold.explainFold;

@RunWith(Traits.class)
public class FoldRightTest {

    @TestTraits({EmptyIterableSupport.class})
    public Fn1<Iterable<Object>, Iterable<Object>> createTestSubject() {
        return foldRight((o, objects) -> objects, singletonList(new Object()));
    }

    @Test
    public void foldRightAccumulatesRightToLeft() {
        assertThat(
                foldRight(explainFold(), "5", asList("1", "2", "3", "4")),
                is("(1 + (2 + (3 + (4 + 5))))")
        );
    }
}
