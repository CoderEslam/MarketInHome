// Generated by view binder compiler. Do not edit!
package com.doubleclick.marktinhome.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.doubleclick.marktinhome.R;
import com.google.android.material.appbar.MaterialToolbar;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentParentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView ParentRecyceler;

  @NonNull
  public final Button addParent;

  @NonNull
  public final MaterialToolbar materialToolbar;

  @NonNull
  public final Toolbar toolbar;

  private FragmentParentBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView ParentRecyceler, @NonNull Button addParent,
      @NonNull MaterialToolbar materialToolbar, @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.ParentRecyceler = ParentRecyceler;
    this.addParent = addParent;
    this.materialToolbar = materialToolbar;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentParentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentParentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_parent, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentParentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.ParentRecyceler;
      RecyclerView ParentRecyceler = ViewBindings.findChildViewById(rootView, id);
      if (ParentRecyceler == null) {
        break missingId;
      }

      id = R.id.addParent;
      Button addParent = ViewBindings.findChildViewById(rootView, id);
      if (addParent == null) {
        break missingId;
      }

      id = R.id.materialToolbar;
      MaterialToolbar materialToolbar = ViewBindings.findChildViewById(rootView, id);
      if (materialToolbar == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new FragmentParentBinding((ConstraintLayout) rootView, ParentRecyceler, addParent,
          materialToolbar, toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
