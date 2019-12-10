package ru.arvelm.lesson_6;

public enum ResourcesModel {

        first(R.string.app_name, R.layout.view_pager),
        second(R.string.app_name, R.layout.view_pager);

        private int mTitleResourceId;
        private int mLayoutResourceId;

        ResourcesModel(int titleResId, int layoutResId) {
            mTitleResourceId = titleResId;
            mLayoutResourceId = layoutResId;
        }

        public int getTitleResourceId() {
            return mTitleResourceId;
        }

        public int getLayoutResourceId() {
            return mLayoutResourceId;
        }
    }
