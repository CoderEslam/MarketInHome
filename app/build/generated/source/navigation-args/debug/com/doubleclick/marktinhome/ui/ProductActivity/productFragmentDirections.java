package com.doubleclick.marktinhome.ui.ProductActivity;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.doubleclick.marktinhome.R;

public class productFragmentDirections {
  private productFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionProductFragmentToHomeFragment() {
    return new ActionOnlyNavDirections(R.id.action_productFragment_to_homeFragment);
  }
}
