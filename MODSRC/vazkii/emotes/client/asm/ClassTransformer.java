package vazkii.emotes.client.asm;

import java.util.Iterator;

import net.minecraft.launchwrapper.IClassTransformer;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class ClassTransformer implements IClassTransformer {

	@Override
	public byte[] transform(String name, String transformedName, byte[] basicClass) {
		if(transformedName.equals("net.minecraft.client.model.ModelBiped")) {
			log("Starting on " + transformedName);
			String funcName = "setRotationAngles";
			String obfName = "a";
			String funcDesc = "(FFFFFFLnet/minecraft/entity/Entity;)V";
			String obfDesc = "(FFFFFFLsa;)V";
			
			if(LoadingPlugin.runtimeDeobfEnabled)
				funcName = "func_78087_a";
			log("Method is " + funcName + " or " + obfName + " for obf.");
			log("Descriptor is " + funcDesc + " or " + obfDesc + " dor obf.");
			
			ClassReader reader = new ClassReader(basicClass);
			ClassNode node = new ClassNode();
			reader.accept(node, 0);

			for(MethodNode method : node.methods)
				if((method.name.equals(funcName)|| method.name.equals(obfName)) && (method.desc.equals(funcDesc) || method.desc.equals(obfDesc))) {
					log("Found method: " + method.name + " " + method.desc);
					Iterator<AbstractInsnNode> iterator = method.instructions.iterator();

					while(iterator.hasNext()) {
						AbstractInsnNode anode = (AbstractInsnNode) iterator.next();
						if(anode.getOpcode() == Opcodes.RETURN) {
							log("RETURN Opcode found");
							InsnList newInstructions = new InsnList();

							newInstructions.add(new VarInsnNode(Opcodes.ALOAD, 7));
							newInstructions.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "vazkii/emotes/client/emote/base/EmoteHandler", "updateEmotes", "(Lnet/minecraft/entity/Entity;)V"));

							method.instructions.insertBefore(anode, newInstructions);
							log("Patched!");
						}
					}

					ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
					node.accept(writer);
					return writer.toByteArray();
				}
		}

		return basicClass;
	}

	private static void log(String str) {
		System.out.println("[Emotes][ASM] " + str);
	}
}
