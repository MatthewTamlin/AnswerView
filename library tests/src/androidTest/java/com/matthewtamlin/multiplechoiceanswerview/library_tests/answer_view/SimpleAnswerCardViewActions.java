/*
 * Copyright 2017 Matthew Tamlin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.matthewtamlin.multiplechoiceanswerview.library_tests.answer_view;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.view.View;

import com.matthewtamlin.multiple_choice_answer_view.library.answer_view.SimpleAnswerCard;
import com.matthewtamlin.multiple_choice_answer_view.library.answer.Answer;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;

/**
 * Custom Espresso view actions which can be applied to SimpleAnswerCard views.
 */
public class SimpleAnswerCardViewActions {
	/**
	 * The duration to wait for asynchronous events to finish, measured in milliseconds
	 */
	private static final int WAIT_FOR_ASYNC_EVENTS_TO_FINISH_MS = 1500;

	/**
	 * Creates a ViewAction which can be applied to a SimpleAnswerCard to set the animation
	 * duration.
	 *
	 * @param animationDurationMs
	 * 		the animation duration to set, measured in milliseconds, at least zero
	 * @return the view action
	 */
	public static ViewAction setAnimationDurationMs(final int animationDurationMs) {
		return new ViewAction() {
			@Override
			public Matcher<View> getConstraints() {
				return isAssignableFrom(SimpleAnswerCard.class);
			}

			@Override
			public String getDescription() {
				return "set animation duration to " + animationDurationMs;
			}

			@Override
			public void perform(final UiController uiController, final View view) {
				((SimpleAnswerCard) view).setAnimationDurationMs(animationDurationMs);
			}
		};
	}

	/**
	 * Creates a ViewAction which can be applied to a SimpleAnswerCard to set the status.
	 *
	 * @param marked
	 * 		whether or not the view should be marked
	 * @param selected
	 * 		whether or not the view should be selected
	 * @param animate
	 * 		whether or not any resulting UI changes should be animated
	 * @return the view action
	 */
	public static ViewAction setStatus(final boolean marked, final boolean selected,
			final boolean animate) {
		return new ViewAction() {
			@Override
			public Matcher<View> getConstraints() {
				return isAssignableFrom(SimpleAnswerCard.class);
			}

			@Override
			public String getDescription() {
				return "set marked to " + marked + " and set selected to " + selected +
						(animate ? " using animation" : " without animation");
			}

			@Override
			public void perform(final UiController uiController, final View view) {
				((SimpleAnswerCard) view).setStatus(marked, selected, animate);

				if (animate) {
					uiController.loopMainThreadForAtLeast(WAIT_FOR_ASYNC_EVENTS_TO_FINISH_MS);
				}
			}
		};
	}

	/**
	 * Creates a ViewAction which can be applied to a SimpleAnswerCard to set the answer.
	 *
	 * @param answer
	 * 		the answer to set, may be null
	 * @param animate
	 * 		whether or not any resulting UI changes should be animated
	 * @return the view action
	 */
	public static ViewAction setAnswer(final Answer answer, final boolean animate) {
		return new ViewAction() {
			@Override
			public Matcher<View> getConstraints() {
				return isAssignableFrom(SimpleAnswerCard.class);
			}

			@Override
			public String getDescription() {
				return "set answer";
			}

			@Override
			public void perform(final UiController uiController, final View view) {
				((SimpleAnswerCard) view).setAnswer(answer, animate);

				if (animate) {
					uiController.loopMainThreadForAtLeast(WAIT_FOR_ASYNC_EVENTS_TO_FINISH_MS);
				}
			}
		};
	}

	/**
	 * Creates a ViewAction which can be applied to a SimpleAnswerCard to set the identifier.
	 *
	 * @param identifier
	 * 		the identifier to set, may be null
	 * @param animate
	 * 		whether or not any resulting UI changes should be animated
	 * @return the view action
	 */
	public static ViewAction setIdentifier(final CharSequence identifier, final boolean animate) {
		return new ViewAction() {
			@Override
			public Matcher<View> getConstraints() {
				return isAssignableFrom(SimpleAnswerCard.class);
			}

			@Override
			public String getDescription() {
				return "set identifier";
			}

			@Override
			public void perform(final UiController uiController, final View view) {
				((SimpleAnswerCard) view).setIdentifier(identifier, animate);

				if (animate) {
					uiController.loopMainThreadForAtLeast(WAIT_FOR_ASYNC_EVENTS_TO_FINISH_MS);
				}
			}
		};
	}
}