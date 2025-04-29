package org.pikouri

import androidx.compose.ui.window.ComposeUIViewController
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIViewController
import platform.UIKit.addChildViewController
import platform.UIKit.didMoveToParentViewController

@OptIn(ExperimentalForeignApi::class)
fun MainViewController(): UIViewController {
    val composeController = ComposeUIViewController { App() }

    return object : UIViewController(nibName = null, bundle = null) {
        override fun viewDidLoad() {
            super.viewDidLoad()
            // Add Compose view as a child
            addChildViewController(composeController)
            view.addSubview(composeController.view)
            composeController.didMoveToParentViewController(this)

            composeController.view.setFrame(view.bounds)
            composeController.view.autoresizingMask = (
                    platform.UIKit.UIViewAutoresizingFlexibleWidth or
                            platform.UIKit.UIViewAutoresizingFlexibleHeight
                    )
        }

        override fun prefersStatusBarHidden(): Boolean {
            return true // Hide the status bar
        }
    }
}
