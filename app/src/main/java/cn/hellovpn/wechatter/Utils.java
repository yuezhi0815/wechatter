package cn.hellovpn.wechatter;

import android.annotation.SuppressLint;

import androidx.viewpager2.widget.ViewPager2;

import cn.hellovpn.wechatter.transformers.AntiClockSpinTransformation;
import cn.hellovpn.wechatter.transformers.ClockSpinTransformation;
import cn.hellovpn.wechatter.transformers.CubeInDepthTransformation;
import cn.hellovpn.wechatter.transformers.CubeInRotationTransformation;
import cn.hellovpn.wechatter.transformers.CubeOutDepthTransformation;
import cn.hellovpn.wechatter.transformers.CubeOutRotationTransformation;
import cn.hellovpn.wechatter.transformers.CubeOutScalingTransformation;
import cn.hellovpn.wechatter.transformers.DepthPageTransformer;
import cn.hellovpn.wechatter.transformers.DepthTransformation;
import cn.hellovpn.wechatter.transformers.FadeOutTransformation;
import cn.hellovpn.wechatter.transformers.FanTransformation;
import cn.hellovpn.wechatter.transformers.GateTransformation;
import cn.hellovpn.wechatter.transformers.HingeTransformation;
import cn.hellovpn.wechatter.transformers.VerticalFlipTransformation;
import cn.hellovpn.wechatter.transformers.PopTransformation;
import cn.hellovpn.wechatter.transformers.SimpleTransformation;
import cn.hellovpn.wechatter.transformers.SpinnerTransformation;
import cn.hellovpn.wechatter.transformers.TossTransformation;
import cn.hellovpn.wechatter.transformers.HorizontalFlipTransformation;
import cn.hellovpn.wechatter.transformers.VerticalShutTransformation;
import cn.hellovpn.wechatter.transformers.ZoomInTransformer;
import cn.hellovpn.wechatter.transformers.ZoomOutPageTransformer;

public class Utils {
    @SuppressLint("NewApi")
    public static ViewPager2.PageTransformer getTransformer(int id) {
        switch (id) {
            case R.id.action_anti_clock_spin:
                return new AntiClockSpinTransformation();
            case R.id.action_clock_spin:
                return new ClockSpinTransformation();
            case R.id.action_cube_in_depth:
                return new CubeInDepthTransformation();
            case R.id.action_cube_in_rotate:
                return new CubeInRotationTransformation();
            case R.id.action_cube_out_depth:
                return new CubeOutDepthTransformation();
            case R.id.action_cube_out_rotate:
                return new CubeOutRotationTransformation();
            case R.id.action_cube_out_scaling:
                return new CubeOutScalingTransformation();
            case R.id.action_depth_page:
                return new DepthPageTransformer();
            case R.id.action_depth:
                return new DepthTransformation();
            case R.id.action_fade_out:
                return new FadeOutTransformation();
            case R.id.action_fan:
                return new FanTransformation();
            case R.id.action_gate:
                return new GateTransformation();
            case R.id.action_hinge:
                return new HingeTransformation();
            case R.id.action_horizontal_flip:
                return new VerticalFlipTransformation();
            case R.id.action_pop:
                return new PopTransformation();
            case R.id.action_simple_transformation:
                return new SimpleTransformation();
            case R.id.action_spinner:
                return new SpinnerTransformation();
            case R.id.action_toss:
                return new TossTransformation();
            case R.id.action_vertical_flip:
                return new HorizontalFlipTransformation();
            case R.id.action_vertical_shut:
                return new VerticalShutTransformation();
            case R.id.action_zoom_out:
                return new ZoomOutPageTransformer();
            case R.id.action_zoom_in:
                return new ZoomInTransformer();
        }

        return null;
    }
}
