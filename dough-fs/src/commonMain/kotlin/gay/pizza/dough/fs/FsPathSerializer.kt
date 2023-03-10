package gay.pizza.dough.fs

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

open class FsPathSerializer(val resolver: FsPathResolver) : KSerializer<FsPath> {
  override val descriptor: SerialDescriptor = String.serializer().descriptor

  override fun deserialize(decoder: Decoder): FsPath {
    return resolver.resolve(decoder.decodeString())
  }

  override fun serialize(encoder: Encoder, value: FsPath) {
    encoder.encodeString(value.fullPathString)
  }
}
