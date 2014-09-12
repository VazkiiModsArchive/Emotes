package vazkii.emotes.client.asm;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;

public class LoadingPlugin implements IFMLLoadingPlugin {

	public static boolean runtimeDeobfEnabled = false;
	
	@Override
	public String[] getASMTransformerClass() {
		return new String[]{ "vazkii.emotes.client.asm.ClassTransformer" };
	}

	@Override
	public String getModContainerClass() {
		return null;
	}

	@Override
	public String getSetupClass() {
		return null;
	}

	@Override
	public void injectData(Map<String, Object> data) {
		runtimeDeobfEnabled = (Boolean) data.get("runtimeDeobfuscationEnabled");
	}

	@Override
	public String getAccessTransformerClass() {
		return null;
	}

}
