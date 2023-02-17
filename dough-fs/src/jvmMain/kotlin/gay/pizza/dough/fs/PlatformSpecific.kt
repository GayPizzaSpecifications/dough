package gay.pizza.dough.fs

import java.nio.file.FileSystems

actual val PlatformFsProvider: FsProvider = JavaFsProvider(FileSystems.getDefault())
