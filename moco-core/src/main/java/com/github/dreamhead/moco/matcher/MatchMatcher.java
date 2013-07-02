package com.github.dreamhead.moco.matcher;

import com.github.dreamhead.moco.MocoConfig;
import com.github.dreamhead.moco.RequestExtractor;
import com.github.dreamhead.moco.RequestMatcher;
import com.google.common.base.Predicate;

import java.util.regex.Pattern;

public class MatchMatcher<T> extends AbstractOperatorMatcher<T> {
    public MatchMatcher(final RequestExtractor<T> extractor, final Pattern pattern) {
        super(extractor, new Predicate<String>() {

            @Override
            public boolean apply(String input) {
                return pattern.matcher(input).matches();
            }
        });
    }

    @Override
    public RequestMatcher apply(final MocoConfig config) {
        return this;
    }
}
