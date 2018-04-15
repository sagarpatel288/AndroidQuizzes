package com.example.android.androidquizzes.ui.activities;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.android.androidquizzes.R;
import com.example.android.androidquizzes.utils.UtilMethods;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //region XML Parsed UI Variables
    @BindView(R.id.rbtn_ans_1_a)
    RadioButton rbtnAns1A;
    @BindView(R.id.rbtn_ans_1_b)
    RadioButton rbtnAns1B;
    @BindView(R.id.rbtn_ans_1_c)
    RadioButton rbtnAns1C;
    @BindView(R.id.rbtn_ans_1_d)
    RadioButton rbtnAns1D;
    @BindView(R.id.rbtn_ans_2_a)
    RadioButton rbtnAns2A;
    @BindView(R.id.rbtn_ans_2_b)
    RadioButton rbtnAns2B;
    @BindView(R.id.rbtn_ans_2_c)
    RadioButton rbtnAns2C;
    @BindView(R.id.rbtn_ans_2_d)
    RadioButton rbtnAns2D;
    @BindView(R.id.rbtn_ans_3_a)
    RadioButton rbtnAns3A;
    @BindView(R.id.rbtn_ans_3_b)
    RadioButton rbtnAns3B;
    @BindView(R.id.rbtn_ans_3_c)
    RadioButton rbtnAns3C;
    @BindView(R.id.rbtn_ans_3_d)
    RadioButton rbtnAns3D;
    @BindView(R.id.cb_ans_4_a)
    CheckBox cbAns4A;
    @BindView(R.id.cb_ans_4_b)
    CheckBox cbAns4B;
    @BindView(R.id.cb_ans_4_c)
    CheckBox cbAns4C;
    @BindView(R.id.cb_ans_4_d)
    CheckBox cbAns4D;
    @BindView(R.id.rbtn_ans_5_a)
    RadioButton rbtnAns5A;
    @BindView(R.id.rbtn_ans_5_b)
    RadioButton rbtnAns5B;
    @BindView(R.id.rbtn_ans_5_c)
    RadioButton rbtnAns5C;
    @BindView(R.id.rbtn_ans_5_d)
    RadioButton rbtnAns5D;
    @BindView(R.id.rbtn_ans_6_a)
    RadioButton rbtnAns6A;
    @BindView(R.id.rbtn_ans_6_b)
    RadioButton rbtnAns6B;
    @BindView(R.id.rbtn_ans_6_c)
    RadioButton rbtnAns6C;
    @BindView(R.id.rbtn_ans_6_d)
    RadioButton rbtnAns6D;
    @BindView(R.id.rbtn_ans_7_a)
    RadioButton rbtnAns7A;
    @BindView(R.id.rbtn_ans_7_b)
    RadioButton rbtnAns7B;
    @BindView(R.id.rbtn_ans_7_c)
    RadioButton rbtnAns7C;
    @BindView(R.id.rbtn_ans_7_d)
    RadioButton rbtnAns7D;
    @BindView(R.id.rbtn_ans_8_a)
    RadioButton rbtnAns8A;
    @BindView(R.id.rbtn_ans_8_b)
    RadioButton rbtnAns8B;
    @BindView(R.id.rbtn_ans_8_c)
    RadioButton rbtnAns8C;
    @BindView(R.id.rbtn_ans_8_d)
    RadioButton rbtnAns8D;
    @BindView(R.id.tiet_ans_9)
    TextInputEditText tietAns9;
    @BindView(R.id.til_ans_9)
    TextInputLayout tilAns9;
    @BindView(R.id.tiet_ans_10)
    TextInputEditText tietAns10;
    @BindView(R.id.til_ans_10)
    TextInputLayout tilAns10;
    @BindView(R.id.btn_submit_check_ans)
    Button btnSubmitCheckAns;
    @BindView(R.id.rg_que_1)
    RadioGroup rgQue1;
    @BindView(R.id.rg_que_2)
    RadioGroup rgQue2;
    @BindView(R.id.rg_que_3)
    RadioGroup rgQue3;
    @BindView(R.id.rg_que_5)
    RadioGroup rgQue5;
    @BindView(R.id.rg_que_6)
    RadioGroup rgQue6;
    @BindView(R.id.rg_que_7)
    RadioGroup rgQue7;
    @BindView(R.id.rg_que_8)
    RadioGroup rgQue8;
    //endregion

    //region Class variables
    private int score = 0;
    private int checkBoxScore = 0;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    /**
     * Gets called when user presses {@code {@link #btnSubmitCheckAns}}
     * <p>
     * Shows total of {@code {@link #score}} & {@code {@link #checkBoxScore}} achieved by user
     * <p>
     *
     * @param view It is {@code {@link #btnSubmitCheckAns}} itself but can be any other view as well
     * @since 1.0
     */
    public void onClickSubmit(View view) {
        Toast.makeText(this,
                getString(R.string.msg_score)
                        .replace("#",
                                String.valueOf(
                                        getScore(getViewsToCheck()) + getScoreFromCheckBoxes(getCheckBoxesToCheck())
                                )
                        ),
                Toast.LENGTH_LONG).show();
        resetQuiz();
    }

    /**
     * Resets all user inputs, clears all given answers
     * <p>
     * Also resets {@link #score} and {@link #checkBoxScore} to zero (0).
     * <p>
     * Being used by (in) {@link #onClickSubmit(View)}
     *
     * @since 1.0
     */
    public void resetQuiz() {
        for (View view : getViewsToCheck()) {
            if (view instanceof RadioGroup) {
                ((RadioGroup) view).clearCheck();
            } else if (view instanceof TextInputEditText) {
                ((TextInputEditText) view).setText("");
            }
        }

        for (CheckBox checkBox : getCheckBoxesToCheck()) {
            checkBox.setChecked(false);
        }

        score = 0;
        checkBoxScore = 0;
    }

    /**
     * Gives mutable {@link #score}
     * <p>
     * Takes {@param views} to be checked. If given view is selectable, should have been checked (hence,
     * only those selectable and checkable views should be given to this method as in form of arguments which
     * should have been checked as right answer) and has checked indeed,
     * the method increases the value of {@link #score}. Thus, we care about radio buttons those should be checked
     * to get the point (increase the {@link #score} by 1) and not other radio buttons.
     * Also, if the given view is having user input type, i.e., edit field, it will check right answer
     * by comparision with the help of method {@link #getScoreFromInputField(View)}
     * <p>
     * Being used inside of {@link #onClickSubmit(View)}
     * Using {@link #getScoreFromInputField(View)} to check user input type views
     *
     * @param views to be checked.
     * @return mutable {@link #score}
     * @since 1.0
     */
    public int getScore(View[] views) {
        for (View view : views) {
            if (view instanceof RadioButton && ((RadioButton) view).isChecked()) {
                score++;
            } else if (view instanceof TextInputEditText) {
                getScoreFromInputField(view);
            }
        }
        return score;
    }

    /**
     * Gives all views those will be used to check user answer
     * <p>
     * Developer should include all views here those are useful to evaluate user's score.
     * If the view is radio button, we care about only right answer and not other.
     * If the view is check box (multiple answers), use {@link #getCheckBoxesToCheck()}
     * If the view is user input field, include it here.
     * <p>
     * Being used as arguments for {@link #getScore(View[])}
     * Being used inside {@link #onClickSubmit(View)}
     *
     * @return An array of views
     * @since 1.0
     */
    public View[] getViewsToCheck() {
        return new View[]{rgQue1, rbtnAns1A, rgQue2, rbtnAns2C, rgQue3, rbtnAns3C,
                rgQue5, rbtnAns5B, rgQue6, rbtnAns6B, rgQue7, rbtnAns7A,
                rgQue8, rbtnAns8B, tietAns9, tietAns10};
    }

    /**
     * Gives mutable {@link #checkBoxScore}
     * <p>
     * Takes {@param checkBoxes} to be verified as an array argument.
     * If given view is selectable, should have been set checked (hence,
     * only those selectable and checkable views should be given to this method as in form of arguments which
     * should have been set checked as right answer) and has been set checked indeed,
     * the method increases the value of {@link #checkBoxScore}.
     * Thus, we care about checkBoxes those should have been set as checked
     * to get the point (increase the {@link #checkBoxScore} by 1) and not other check boxes.
     * <p>
     * Being used inside of {@link #onClickSubmit(View)}
     * Using {@link #hasAllChecked(CheckBox[])} to verify whether all given checkBoxes are set checked or not.
     *
     * @param checkBoxes to be verified.
     * @return mutable {@link #checkBoxScore}
     * @since 1.0
     */
    public int getScoreFromCheckBoxes(CheckBox[] checkBoxes) {
        if (hasAllChecked(checkBoxes)) {
            checkBoxScore++;
        }
        return checkBoxScore;
    }

    /**
     * Gives all checkBoxes those will be verified to check user answer
     * <p>
     * Developer should include all checkBoxes here those are useful to evaluate user's score.
     * If the view is radio button or user input field, include it to {@link #getViewsToCheck()}
     * <p>
     * Being used as arguments for {@link #getScoreFromCheckBoxes(CheckBox[])}
     * Being used inside {@link #onClickSubmit(View)}
     *
     * @return An array of checkBox
     * @since 1.0
     */
    public CheckBox[] getCheckBoxesToCheck() {
        return new CheckBox[]{cbAns4A, cbAns4B, cbAns4C, cbAns4D};
    }

    /**
     * Compares user input string (texts) to right answer and increases the mutable {@link #score} for each
     * right answer
     * <p>
     * Being used inside of {@link #onClickSubmit(View)}
     * Being used by {@link #getScore(View[])}
     * <p>
     * Using {@link UtilMethods#checkNotNullEmpty(String)}
     * to check whether the user input is available or not for the comparision
     *
     * @param view User input field, e.g. EditText, TextInputEditText
     * @see UtilMethods#checkNotNullEmpty(String)
     * @since 1.0
     */
    private void getScoreFromInputField(View view) {
        switch (view.getId()) {
            case R.id.til_ans_9:
            case R.id.tiet_ans_9:
                if (UtilMethods.checkNotNullEmpty(tietAns9.getText().toString())
                        && tietAns9.getText().toString().trim().equalsIgnoreCase(getString(R.string.str_android_device_bridge))) {
                    score++;
                }
                break;

            case R.id.til_ans_10:
            case R.id.tiet_ans_10:
                if (UtilMethods.checkNotNullEmpty(tietAns10.getText().toString())
                        && tietAns10.getText().toString().trim().equalsIgnoreCase(getString(R.string.str_ddms))) {
                    score++;
                }
                break;
        }
    }

    /**
     * A business logic to verify whether all given checkboxes have been set checked or not
     * Being used inside of {@link #getScoreFromCheckBoxes(CheckBox[])}
     *
     * @param checkBoxes to be verified whether they all have been set checked or not
     * @return true if all given checkBoxes have been set checked
     * @since 1.0
     */
    public boolean hasAllChecked(CheckBox[] checkBoxes) {
        List<CheckBox> cboxes = new ArrayList<>();
        for (CheckBox cb : checkBoxes) {
            if (cb.isChecked()) {
                cboxes.add(cb);
            }
        }
        return checkBoxes.length == cboxes.size();
    }
}
