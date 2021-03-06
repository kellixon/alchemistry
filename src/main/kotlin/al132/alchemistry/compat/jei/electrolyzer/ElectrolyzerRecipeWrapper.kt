package al132.alchemistry.compat.jei.electrolyzer

import al132.alchemistry.Reference
import al132.alchemistry.compat.jei.AlchemistryRecipeWrapper
import al132.alchemistry.recipes.ElectrolyzerRecipe
import mezz.jei.api.ingredients.IIngredients
import net.minecraft.client.Minecraft
import net.minecraft.item.ItemStack
import net.minecraftforge.fluids.FluidStack
import java.awt.Color

class ElectrolyzerRecipeWrapper(recipe: ElectrolyzerRecipe) : AlchemistryRecipeWrapper<ElectrolyzerRecipe>(recipe) {

    override fun drawInfo(minecraft: Minecraft?, recipeWidth: Int, recipeHeight: Int, mouseX: Int, mouseY: Int) {

        //TODO localization support
        val textFirst = Reference.DECIMAL_FORMAT.format(recipe.output3Probability) + "%"
        val textLast = Reference.DECIMAL_FORMAT.format(recipe.output4Probability) + "%"

        val x = 104
        var y = 84
        if (!recipe.outputs[2].isEmpty) minecraft!!.fontRenderer.drawString(textFirst, x, y, Color.BLACK.rgb)
        y += 18
        if (!recipe.outputs[3].isEmpty) minecraft!!.fontRenderer.drawString(textLast, x, y, Color.BLACK.rgb)
    }

    override fun getIngredients(ingredients: IIngredients) {
        ingredients.setInput(FluidStack::class.java, recipe.input)
        ingredients.setInputs(ItemStack::class.java, recipe.electrolytes)
        ingredients.setOutputs(ItemStack::class.java, recipe.outputs)
    }
}